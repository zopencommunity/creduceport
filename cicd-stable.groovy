node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/creduceport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/creduceport.git'), string(name: 'PORT_DESCRIPTION', value: 'C-Reduce, a C and C++ program reducer' ), string(name: 'BUILD_LINE', value: 'STABLE') ]
  }
}
