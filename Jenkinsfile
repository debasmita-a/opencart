pipeline{
    
    agent any
    
    stages{
        stage("Build"){
            steps{
                 echo("Deploy to Dev env.")
            }
        }  
        stage("QA"){
            steps{
                 echo("Deploy to QA env.")
            }
        }
        
         stage("Stage"){
            steps{
                 echo("Deploy to Stage env.")
            }
        }
        
         stage("Prod"){
            steps{
                 echo("Deploy to Prod env.")
            }
        }
    }
}