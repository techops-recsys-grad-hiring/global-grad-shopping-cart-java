$install_java = <<SCRIPT
    sudo yum -y install java-1.8.0-openjdk
SCRIPT


Vagrant.configure(2) do |config|

  config.vm.box = "centos/7"

  config.vm.network "forwarded_port", guest: 8080, host: 8080

  config.vm.provision "shell", inline: $install_java

end
