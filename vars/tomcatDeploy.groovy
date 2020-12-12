         
def call(tomcatIp,tomcatUsr,finalWarName){
  sh "mv target/myweb*.war target/${finalWarName}.war
  sshagent(['2e29b303-b5bd-4247-a3ce-ebceb61fb037']){
       sh "scp -o StrictHostKeyChecking=no target/${finalWarName}.war ${tomcatUsr}@${tomcatIp}:/opt/tomcat8/webapps"
        sh """
             ssh ${tomcatUsr}@${tomcatIp} /opt/tomcat8/bin/shutdown.sh
             ssh ${tomcatUsr}@${tomcatIp} /opt/tomcat8/bin/startup.sh
          """
	  }
            }
