#! /usr/bin/python

import sys, re, htmlentitydefs, getopt, StringIO

# minimum line size, we add a zero-sized breakable space every
# LINESIZE characters
linesize = 20
tabsize = 8
show_CR = False

html_hdr = """<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
            <html><head>
		<meta name="generator" content="diff2html.rb; charset=utf8" />
		<title>HTML Diff</title>
		<style>
			table { border:0px; border-collapse:collapse; width: 100%; font-size:0.75em; font-family: Lucida Console, monospace }
			td.line { color:#8080a0 }
			th { background: black; color: white }
			tr.diffunmodified td { background: #D0D0E0 }
			tr.diffhunk td { background: #A0A0A0 }
			tr.diffadded td { background: #CCFFCC }
			tr.diffdeleted td { background: #FFCCCC }
			tr.diffchanged td { background: #FFFFA0 }
			span.diffchanged2 { background: #E0C880 }
			span.diffponct { color: #B08080 }
			tr.diffmisc td {}
			tr.diffseparator td {}
		</style>
		</head>
		<body>
"""

html_footer = """
</body></html>
"""

table_hdr = """
		<table class="diff">
"""

table_footer = """
</table>
"""

DIFFON = "\x01"
DIFFOFF = "\x02"

buf = []
add_cpt, del_cpt = 0, 0
line1, line2 = 0, 0
hunk_off1, hunk_size1, hunk_off2, hunk_size2 = 0, 0, 0, 0


# Characters we're willing to word wrap on
WORDBREAK = " \t;.,/):"

def sane(x):
    r = ""
    for i in x:
        j = ord(i)
        if i not in ['\t', '\n'] and ((j < 32) or (j >= 127)):
            r = r + "."
        else:
            r = r + i
    return r

def linediff(s, t):
    if len(s):
        s = str(reduce(lambda x, y:x+y, [ sane(c) for c in s ]))
    if len(t):
        t = str(reduce(lambda x, y:x+y, [ sane(c) for c in t ]))

    m, n = len(s), len(t)
    d = [[(0, 0) for i in range(n+1)] for i in range(m+1)]
    x = [[(0, 0) for i in range(n+1)] for i in range(m+1)]


    d[0][0] = (0, (0, 0))
    for i in range(m+1)[1:]:
        d[i][0] = (i,(i-1, 0))
    for j in range(n+1)[1:]:
        d[0][j] = (j,(0, j-1))

    for i in range(m+1)[1:]:
        for j in range(n+1)[1:]:
            if s[i-1] == t[j-1]:
                cost = 0
            else:
                cost = 1
            d[i][j] = min((d[i-1][j][0] + 1, (i-1, j)),
                          (d[i][j-1][0] + 1, (i, j-1)),
                          (d[i-1][j-1][0] + cost, (i-1, j-1)))

    l = []
    coord = (m, n)
    while coord != (0, 0):
        l.insert(0, coord)
        x, y = coord
        coord = d[x][y][1]

    l1 = []
    l2 = []

    for coord in l:
        cx, cy = coord
        child_val = d[cx][cy][0]

        father_coord = d[cx][cy][1]
        fx, fy = father_coord
        father_val = d[fx][fy][0]

        diff = (cx-fx, cy-fy)

        if diff == (0, 1):
            l1.append("")
            l2.append(DIFFON + t[fy] + DIFFOFF)
        elif diff == (1, 0):
            l1.append(DIFFON + s[fx] + DIFFOFF)
            l2.append("")
        elif child_val-father_val == 1:
            l1.append(DIFFON + s[fx] + DIFFOFF)
            l2.append(DIFFON + t[fy] + DIFFOFF)
        else:
            l1.append(s[fx])
            l2.append(t[fy])

    r1, r2 = (reduce(lambda x, y:x+y, l1), reduce(lambda x, y:x+y, l2))
    return r1, r2


def convert(s, linesize=0, ponct=0):
    i = 0
    t = ""
    for c in s:
        # used by diffs
        if c == DIFFON:
            t += '<span class="diffchanged2">'
        elif c == DIFFOFF:
            t += "</span>"

        # special html chars
        elif htmlentitydefs.codepoint2name.has_key(ord(c)):
            t += "&%s;" % (htmlentitydefs.codepoint2name[ord(c)])
            i += 1

        # special highlighted chars
        elif c == "\t" and ponct == 1:
            n = tabsize-(i%tabsize)
            if n == 0:
                n = tabsize
            t += ('<span class="diffponct">&raquo;</span>'+'&nbsp;'*(n-1))
        elif c == " " and ponct == 1:
            t += '<span class="diffponct">&middot;</span>'
        elif c == "\n" and ponct == 1:
            if show_CR:
                t += '<span class="diffponct">\</span>'
        else:
            t += c
            i += 1

        if linesize and (WORDBREAK.count(c) == 1):
            t += '&#8203;'
            i = 0
        if linesize and i > linesize:
            i = 0
            t += "&#8203;"

    return t


def add_comment(s, output_file):
    output_file.write('<tr class="diffmisc"><td colspan="4">%s</td></tr>\n'%convert(s))

def add_filename(f1, f2, output_file):
    output_file.write("<tr><th colspan='2'>%s</th>"%convert(f1, linesize=linesize))
    output_file.write("<th colspan='2'>%s</th></tr>\n"%convert(f2, linesize=linesize))

def add_hunk(output_file, show_hunk_infos):
    if show_hunk_infos:
        output_file.write('<tr class="diffhunk"><td colspan="2">Offset %d, %d lines modified</td>'%(hunk_off1, hunk_size1))
        output_file.write('<td colspan="2">Offset %d, %d lines modified</td></tr>\n'%(hunk_off2, hunk_size2))
    else:
        # &#8942; - vertical ellipsis
        output_file.write('<tr class="diffhunk"><td colspan="2">&#8942;</td><td colspan="2">&#8942;</td></tr>')


def add_line(s1, s2, output_file):
    global line1
    global line2

    if s1 == None and s2 == None:
        type_name = "unmodified"
    elif s1 == None or s1 == "":
        type_name = "added"
    elif s2 == None or s1 == "":
        type_name = "deleted"
    elif s1 == s2:
        type_name = "unmodified"
    else:
        type_name = "changed"
        s1, s2 = linediff(s1, s2)

    output_file.write('<tr class="diff%s">' % type_name)
    if s1 != None and s1 != "":
        output_file.write('<td class="diffline">%d </td>' % line1)
        output_file.write('<td class="diffpresent">')
        output_file.write(convert(s1, linesize=linesize, ponct=1))
        output_file.write('</td>')
    else:
        s1 = ""
        output_file.write('<td colspan="2"> </td>')

    if s2 != None and s2 != "":
        output_file.write('<td class="diffline">%d </td>'%line2)
        output_file.write('<td class="diffpresent">')
        output_file.write(convert(s2, linesize=linesize, ponct=1))
        output_file.write('</td>')
    else:
        s2 = ""
        output_file.write('<td colspan="2"></td>')

    output_file.write('</tr>\n')

    if s1 != "":
        line1 += 1
    if s2 != "":
        line2 += 1


def empty_buffer(output_file):
    global buf
    global add_cpt
    global del_cpt

    if del_cpt == 0 or add_cpt == 0:
        for l in buf:
            add_line(l[0], l[1], output_file)

    elif del_cpt != 0 and add_cpt != 0:
        l0, l1 = [], []
        for l in buf:
            if l[0] != None:
                l0.append(l[0])
            if l[1] != None:
                l1.append(l[1])
        max_len = (len(l0) > len(l1)) and len(l0) or len(l1)
        for i in range(max_len):
            s0, s1 = "", ""
            if i < len(l0):
                s0 = l0[i]
            if i < len(l1):
                s1 = l1[i]
            add_line(s0, s1, output_file)

    add_cpt, del_cpt = 0, 0
    buf = []


def parse_input(input_file, output_file,
                exclude_headers, show_hunk_infos):
    global add_cpt, del_cpt
    global line1, line2
    global hunk_off1, hunk_size1, hunk_off2, hunk_size2

    if not exclude_headers:
        output_file.write(html_hdr)
    output_file.write(table_hdr)

    while True:
        l = input_file.readline()
        if l == "":
            break

        m = re.match('^--- ([^\s]*)', l)
        if m:
            empty_buffer(output_file)
            file1 = m.groups()[0]
            while True:
                l = input_file.readline()
                m = re.match('^\+\+\+ ([^\s]*)', l)
                if m:
                    file2 = m.groups()[0]
                    break
            add_filename(file1, file2, output_file)
            hunk_off1, hunk_size1, hunk_off2, hunk_size2 = 0, 0, 0, 0
            continue

        m = re.match("@@ -(\d+),?(\d*) \+(\d+),?(\d*)", l)
        if m:
            empty_buffer(output_file)
            hunk_data = map(lambda x:x=="" and 1 or int(x), m.groups())
            hunk_off1, hunk_size1, hunk_off2, hunk_size2 = hunk_data
            line1, line2 = hunk_off1, hunk_off2
            add_hunk(output_file, show_hunk_infos)
            continue

        if hunk_size1 == 0 and hunk_size2 == 0:
            empty_buffer(output_file)
            add_comment(l, output_file)
            continue

        if re.match("^\+", l):
            add_cpt += 1
            hunk_size2 -= 1
            buf.append((None, l[1:]))
            continue

        if re.match("^\-", l):
            del_cpt += 1
            hunk_size1 -= 1
            buf.append((l[1:], None))
            continue

        if re.match("^\ ", l) and hunk_size1 and hunk_size2:
            empty_buffer(output_file)
            hunk_size1 -= 1
            hunk_size2 -= 1
            buf.append((l[1:], l[1:]))
            continue

        empty_buffer(output_file)
        add_comment(l, output_file)

    empty_buffer(output_file)
    output_file.write(table_footer)
    if not exclude_headers:
        output_file.write(html_footer)


def usage():
    print '''
diff2html.py [-i file] [-o file] [-x]
diff2html.py -h

Transform a unified diff from stdin to a colored side-by-side HTML
page on stdout.

   -i file     set input file, else use stdin
   -o file     set output file, else use stdout
   -x          exclude html header and footer
   -t tabsize  set tab size (default 8)
   -l linesize set maximum line size is there is no word break (default 20)
   -r          show \\r characters
   -k          show hunk infos
   -h          show help and exit
'''

def main():
    global linesize, tabsize
    global show_CR

    input_file = sys.stdin
    output_file = sys.stdout

    exclude_headers = False
    show_hunk_infos = False

    try:
        opts, args = getopt.getopt(sys.argv[1:], "hi:o:xt:l:rk",
                                   ["help",  "input=", "output=",
                                    "exclude-html-headers", "tabsize=",
                                    "linesize=", "show-cr", "show-hunk-infos"])
    except getopt.GetoptError, err:
        print str(err) # will print something like "option -a not recognized"
        usage()
        sys.exit(2)
    verbose = False
    for o, a in opts:
        if o in ("-h", "--help"):
            usage()
            sys.exit()
        elif o in ("-i", "--input"):
            input_file = open(a, "r")
        elif o in ("-o", "--output"):
            output_file = open(a, "w")
        elif o in ("-x", "--exclude-html-headers"):
            exclude_headers = True
        elif o in ("-t", "--tabsize"):
            tabsize = int(a)
        elif o in ("-l", "--linesize"):
            linesize = int(a)
        elif o in ("-r", "--show-cr"):
            show_CR = True
        elif o in ("-k", "--show-hunk-infos"):
            show_hunk_infos = True
        else:
            assert False, "unhandled option"
    parse_input(input_file, output_file,
                exclude_headers, show_hunk_infos)

def parse_from_memory(txt, exclude_headers, show_hunk_infos):
    " Parses diff from memory and returns a string with html "
    stream = StringIO.StringIO(txt)
    parse_input(stream, stream, exclude_headers, show_hunk_infos)
    return stream.buf

if __name__ == "__main__":
    main()
