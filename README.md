# SutdaGame
<h3>자바 소켓을 활용한 게임 입니다.</h3>
자세한 기능들에 대한 설명은 <a href="https://github.com/dbtjsdlf222/SutdaGameClient">섯다 클라이언트</a>에 있습니다.

언어 Java 11<br>
빌드도구 Maven<br>

사용 라이브러리
<ul>
  <li>jackson</li>
  <li>slf4j</li>
  <li>mysql-connector</li>
  <li>jbcrypt</li>
</ul>

게임 서버는 60여개의 프로토콜로 클라이언트와 TCP Socket통신을 하며,<br> 
접속할 때마다 서버와 클라이언트 사이에 통신 쓰레드가 생깁니다.

<br>서버 접속 제한 인원 수는 10명으로 제한된 상태이며, 
<br>이는 쓰레드풀로 관리합니다
