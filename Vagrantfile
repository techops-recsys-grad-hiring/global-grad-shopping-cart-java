$install_java = <<SCRIPT
    sudo yum -y install java-1.8.0-openjdk-devel
SCRIPT

$build_api = <<SCRIPT
    cd /vagrant
    ./gradlew build
SCRIPT

$run_api = <<SCRIPT
    java -jar /vagrant/build/libs/thoughtful-rose-0.1.0.jar &
SCRIPT


Vagrant.configure(2) do |config|
    config.vm.box = "centos/7"

    config.vm.network "forwarded_port", guest: 8080, host: 8080

    config.vm.provision "shell", inline: $install_java
    config.vm.provision "shell", inline: $build_api
    config.vm.provision "shell", inline: $run_api

end
