#!bin/bash

rm -rf target/
echo "Deleted target/ folder"

mvn clean install -DskipTests=true

echo "Generating jar file"

scp -i "~/Desktop/AWS/pem/vaugst.pem" ec2_cmd.sh ec2-user@ec2-35-175-135-95.compute-1.amazonaws.com:/home/ec2-user
echo "Copied latest 'ec2_cmd.sh' file from local machine to ec2 instance"

scp -i "~/Desktop/AWS/pem/vaugst.pem" target/*.jar ec2-user@ec2-35-175-135-95.compute-1.amazonaws.com:/home/ec2-user
echo "Copied jar file from local machine to ec2 instance"

echo "Connecting to ec2 instance and starting server using java -jar command"
ssh -i "~/Desktop/AWS/pem/vaugst.pem" ec2-user@ec2-35-175-135-95.compute-1.amazonaws.com ./ec2_cmd.sh