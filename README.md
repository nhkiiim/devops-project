## Jenkins, Nginx, Docker를 활용한 무중단 배포 자동화




### 01. 목표
- Nginx를 활용해 pring Boot 어플리케이션을 블루 그린(Blue-Green Deployment) 방식으로 무중단 배포
- Jenkins, Docker, Docker Hub를 활용해 배포 자동화




__추가 목표__

> DB 연동 및 JPA 활용 <br>
> Travis CI, AWS CodeDeploy 사용해 보기



<br>

### 02. 개요

<img width="1437" alt="스크린샷 2022-08-30 오후 4 19 19" src="https://user-images.githubusercontent.com/59560592/202055097-78cf5138-7988-4f15-9cc7-11f65989096c.png">

- 소스코드 변경 시 GitHub가 Webhook으로 젠킨스 호출
- 젠킨스에서 도커 이미지 빌드 후 push
- EC2 서버에서 도커 이미지 pull 받고 무중단 배포 진행


<br>

### 03. 개념

__무중단 배포__

서비스 장애와 배포의 부담을 최소화하기 위해 운영 중인 서비스를 중단하지 않고 신규 소프트웨어를 배포하는 기술

    1) 롤링(Rolling Update) 방식
    2) 블루 그린(Blue-Green Deployment) 방식
    3) 카나리(Canary Release) 방식


세가지 방식 중 블루 그린(Blue-Green Deployment) 방식을 이용해 프로젝트 진행

<br>

__블루 그린 방식__

블루를 구버전, 그린을 신버전으로 지칭하여 붙여진 이름

운영 환경에 구버전과 동일하게 신버전의 인스턴스를 구성한 후, 로드밸런서를 통해 신버전으로 모든 트래픽을 전환하는 배포 방식


<br>

__Nginx를 이용한 무중단 배포__

