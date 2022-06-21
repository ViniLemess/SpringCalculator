# Spring Calculator Pipeline, How to run.
[Click here to see youtube demo video!](https://www.youtube.com/watch?v=h9gBI-GQHqI)
***
### Requirements :

 >* [Git](https://git-scm.com/downloads "git install")
 >* [Jenkins](https://www.jenkins.io/download/ "jenkins install") (install with recomended plugins)
 >* [Packer](https://www.packer.io/downloads "packer install")
 >* [Ansible](https://docs.ansible.com/ansible/latest/installation_guide/intro_installation.html "ansible install")
 >* [Docker](https://www.docker.com/get-started/ "docker start")
 >* [Dockerhub Account](https://hub.docker.com/ "docker hub page")
 >* [Jfrog Platform Account](https://jfrog.com/start-free/ "jfrog start for free")

***All jobs will be pipelines and we will need to pull the Jenkinsfile's from the branch infra of the repository: https://github.com/ViniLemess/SpringCalculator***

### Job 1 Building App:

    Script Path: infra/job1/Jenkinsfile

To run this Jenkinsfile you will need the Artifactory plugin for jenkins, and inside de **Configure System** page from jenkins 
you must create **Jfrog Platform Instance** with your jfrog server url and as Instance Id you must put ArtifactoryJfrog.
You will also need to set this job as a Github project, passing the url https://github.com/ViniLemess/SpringCalculator.

### Job 2 App Infra:

    Script Path: infra/job2/Jenkinsfile

For this Jenkinsfile you will need to create a **user with password credential** in the **Manage Credentials** page of Jenkins
to store your user and password from dockerhub, the ID must be dockerhub-login, you will also need to create a repository in 
your dockerhub named spring-calculator to store our image.

### Job 3 Running app:

    Script Path: infra/job3/Jenkinsfile

For this step, everything is set up, it will use the credentials you set on the job2.

## Calculator Application Endpoints: 

> * http://localhost:8090/calculator/history
> * http://localhost:8090/calculator/calculate
>   * http://localhost:8090/calculator/calculate?x=11&y=14&operation=sum
>   * http://localhost:8090/calculator/calculate?x=11&y=14&operation=subtract
>   * http://localhost:8090/calculator/calculate?x=11&y=14&operation=multiply
>   * http://localhost:8090/calculator/calculate?x=15&y=3&operation=divide
>   * http://localhost:8090/calculator/calculate?x=5&y=4&operation=power



    



