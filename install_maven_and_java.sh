pwd=`pwd`
echo -e "Downloading Apache Maven ...................."
wget https://apache.osuosl.org/maven/maven-3/3.6.1/binaries/apache-maven-3.6.1-bin.tar.gz
tar -xvzf apache-maven-3.6.1-bin.tar.gz

echo -e "Downloading Java ............................"
wget -c --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-linux-x64.tar.gz
tar -xvzf jdk-8u131-linux-x64.tar.gz
echo "export PATH=.:$pwd/apache-maven-3.6.1/bin:$pwd/jdk1.8.0_131/bin:$PATH" >> ~/.bash_profile
echo "export JAVA_HOME=$pwd/jdk1.8.0_131" >> ~/.bash_profile
chmod +x ~/.bash_profile
. ~/.bash_profile
