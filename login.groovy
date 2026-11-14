def call(String imagename,String imagetag){
    withCredentials([usernamePassword(
        credentialsId:"Admins_ID",
        usernameVariable:"admin",
        passwordVariable:"Pass"
    )])
    {
        sh "docker login -u ${admin} -p ${Pass}"
        sh "docker image tag ${imagename}:${imagetag} ${admin}/${imagename}:${imagetag}"
        sh "docker push ${admin}/${imagename}:${imagetag}"
    }
}