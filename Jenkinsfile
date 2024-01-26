pipeline{
    
    agent any
    
    stages{
        stage("Build"){
            steps{
                 echo("Deploy to Dev env.")
            }
        } 
         
        stage("Regression automation testcases"){
            steps{
                 echo("Deploy to QA env.")
            }
        }
        
         stage("Deploy to Stage"){
            steps{
                 echo("Deploy to Stage env.")
            }
        }
        
         stage("Run sanity automation testcases"){
            steps{
                 echo("Run sanity automation testcases")
            }
        }
        
         stage("Deploy to Prod"){
            steps{
                 echo("Deploy to Prod env.")
            }
        }
    }
}