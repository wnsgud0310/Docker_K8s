# 베이스 이미지 지정
FROM ubuntu:18.04

# 레이블 작성
LABEL maintainer="diversim90 <diversim90@naver.com>"
LABEL title="IaC, Docker application"
LABEL version="1.0.0"
LABEL description="Docker application"

# 환경변수 설정
ENV APACHE_WEB_DIR /var/www/html

# 패키지 설치
RUN apt-get update
RUN apt-get install -y apache2
RUN apt-get install -y git
RUN apt-get install -y curl
RUN apt-get install -y ssh
RUN apt-get install -y wget

# apache 기본 페이지 작성
RUN echo 'Hello, Docker Application.' > /var/www/html/index.html

# 접속할 포트 오픈
EXPOSE 80

# 이미지가 컨테이너로 실행될 때 아파치 서비스를 자동으로 실행되도록 설정
CMD ["/usr/sbin/apache2ctl", "-D", "FOREGROUND"]