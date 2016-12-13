#!/usr/bin/python
import sys, os, string

def main( ) :
	REMOTE_HOST = '10.106.23.169'
	#REMOTE_HOST = '10.10.69.170'
	TOMCAT_HOME = '/usr/apache-tomcat-7.0.34'
	
	#
	os.system( 'export LANG=en_US.UTF-8;' )
	os.system( 'export LC_ALL=en_US.UTF-8;' )
	
	result = raw_input( '\n\n\n\nYou will deploy the new war to web-server and restart it, continue? (y/n) :  ' )
	if result == 'n' :
		sys.exit( 0 )
	
	# compile and deploy
	os.system( 'scp -rv -P 22022 target/*.war root@'+REMOTE_HOST+':'+TOMCAT_HOME+'/webapps/')
	os.system( 'scp -rv -P 22022 smart_tomcat_restart.sh root@'+REMOTE_HOST+':'+TOMCAT_HOME+'/')
	
	# restart
	os.system( 'ssh -l root -p 22022 ' + REMOTE_HOST)
	
	sys.exit(0)

if __name__ == '__main__' :
    sys.exit(main())
