# espm.poo25.1

Exemplo de Hello World!
```java
package poo.aula01;

public class Hello {

    public static void main(String[] args) {
        System.out.println("Ola Mundo!");
    }
    
}
```


## Docker

Baixe o Docker Desktop no site oficial: [https://www.docker.com/products/docker-desktop](https://www.docker.com/products/docker-desktop)

Docker é um gerenciador de containers, onde cada containers é uma emulação de uma máquina virtual, porém mais leve e mais rápido.

Exemplo de Docker file:
```Dockerfile
FROM ubuntu:latest
RUN apt-get update
RUN apt-get install -y iputils-ping
CMD ["tail", "-f", "/dev/null"]
```

### Comandos do terminal

Para criar uma imagem a partir de um Dockerfile, utilize o comando:
```bash
docker build -t espm-ubuntu .
```

Para executar um container a partir de uma imagem, utilize o comando:
```bash
docker run espm-ubuntu
```