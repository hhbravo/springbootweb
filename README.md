#Run Mvn sonar cloudscan
SONAR_TOKEN=4ebdf66856bf2d29cf65942dd329d2127f583933

mvn sonar:sonar \
   -Dsonar.projectKey=lmartinez63_springbootweb \
   -Dsonar.organization=lmartinez63 \
   -Dsonar.host.url=https://sonarcloud.io \
   -Dsonar.login=4ebdf66856bf2d29cf65942dd329d2127f583933

# springbootweb
# springbootwebSonarCloud
