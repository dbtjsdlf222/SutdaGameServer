# SutdaGame
<h3>자바 소켓을 활용한 게임 입니다.</h3>

언어 Java 11<br>
빌드도구 Maven<br>
버전관리 Git<br>
DB MySQL<br>
서버 개발 인원 2명

사용 라이브러리
<ul>
  <li>jackson</li>
  <li>slf4j</li>
  <li>mysql-connector</li>
  <li>jbcrypt</li>
</ul>



<p>- 게임 서버는 60여개의 프로토콜로 클라이언트와 TCP Socket 통신을 하며, <br>플레이어가 접속할 때마다 통신 쓰레드가 하나 생성 됩니다.</p>

<p>- 서버 접속 제한 인원 수는 10명으로 제한된 상태이며, 이는 쓰레드풀로 관리합니다</p> 
<p>- 개선 할 부분들이 보이는 즉시 memo 패키지에 적어 놓으며 하나씩 줄여나갔습니다. </p>

<br>
**자세한 게임 기능들에 대한 설명은 <a href="https://github.com/dbtjsdlf222/SutdaGameClient">섯다 클라이언트</a>에 있습니다.**
