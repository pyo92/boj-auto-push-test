
<div class="headline">
<h2>문제</h2>
</div>
<div id="problem_description" class="problem-text">
<p>2019 HEPC - MAVEN League의 "<a href="/problem/17218">비밀번호 만들기</a>"와 같은 방식으로 비밀번호를 만든 경민이는 한 가지 문제점을 발견하였다. 비밀번호가 랜덤으로 만들어져서 기억을 못 한다는 것이었다! 그래서 경민이는 메모장에 사이트의 주소와 비밀번호를 저장해두기로 했다. 하지만 컴맹인 경민이는 메모장에서 찾기 기능을 활용하지 못하고&nbsp;직접 눈으로 사이트의 주소와 비밀번호를 찾았다. 메모장에 저장된 사이트의 수가 늘어나면서&nbsp;경민이는 비밀번호를 찾는 일에 시간을 너무 많이 쓰게 되었다. 이를 딱하게 여긴 문석이는 경민이를 위해 메모장에서 비밀번호를 찾는 프로그램을 만들기로 결심하였다! 문석이를 도와 경민이의 메모장에서 비밀번호를 찾아주는 프로그램을 만들어보자.</p>
</div>

<div class="headline">
<h2>입력</h2>
</div>
<div id="problem_input" class="problem-text">
<p>첫째 줄에 저장된 사이트 주소의 수 N(1&nbsp;≤ N&nbsp;≤ 100,000)과 비밀번호를 찾으려는 사이트 주소의 수 M(1&nbsp;≤ M&nbsp;≤ 100,000)이 주어진다.</p>
<p>두번째 줄부터 N개의 줄에 걸쳐&nbsp;각 줄에 사이트 주소와 비밀번호가 공백으로 구분되어 주어진다. 사이트 주소는 알파벳 소문자,&nbsp;알파벳 대문자,&nbsp;대시('-'), 마침표('.')로 이루어져 있고, 중복되지 않는다. 비밀번호는 알파벳 대문자로만 이루어져 있다. 모두 길이는 최대 20자이다.</p>
<p>N+2번째 줄부터 M개의 줄에 걸쳐 비밀번호를 찾으려는 사이트 주소가 한줄에 하나씩 입력된다. 이때,&nbsp;반드시 이미 저장된 사이트 주소가 입력된다.</p>
</div>

<div class="headline">
<h2>출력</h2>
</div>
<div id="problem_output" class="problem-text">
<p>첫 번째 줄부터 M개의 줄에 걸쳐&nbsp;비밀번호를 찾으려는 사이트 주소의 비밀번호를 차례대로 각 줄에 하나씩 출력한다.</p>
</div>

<div class="headline">
<h2>제한</h2>
</div>
<div id="problem_limit" class="problem-text">
</div>

<div class="headline">
<h2>예제 입력 1
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-input-1">복사</button>
</h2>
</div>

```
16 4
noj.am IU
acmicpc.net UAENA
startlink.io THEKINGOD
google.com ZEZE
nate.com VOICEMAIL
naver.com REDQUEEN
daum.net MODERNTIMES
utube.com BLACKOUT
zum.com LASTFANTASY
dreamwiz.com RAINDROP
hanyang.ac.kr SOMEDAY
dhlottery.co.kr BOO
duksoo.hs.kr HAVANA
hanyang-u.ms.kr OBLIVIATE
yd.es.kr LOVEATTACK
mcc.hanyang.ac.kr ADREAMER
startlink.io
acmicpc.net
noj.am
mcc.hanyang.ac.kr
```

<div class="headline">
<h2>예제 출력 1
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-output-1">복사</button>
</h2>
</div>

```
THEKINGOD
UAENA
IU
ADREAMER
```

<div class="headline">
<h2>노트</h2>
</div>
<div id="problem_hint" class="problem-text">
<p>입출력 방식이 느리면 여러 줄을 입력받거나 출력할 때 시간초과가 날 수 있다.</p>
<p>C++을 사용하고 있고&nbsp;<code>cin</code>/<code>cout</code>을 사용하고자 한다면, main함수 안에&nbsp;<code>cin.tie(NULL)</code>과 <code>ios::sync_with_stdio(false)함수를</code>&nbsp;둘 다 호출해 주고,&nbsp;<code>endl</code>&nbsp;대신 개행문자(<code>\n</code>)를 쓰자.&nbsp;단, 이렇게 하면 더 이상&nbsp;<code>scanf</code>/<code>printf</code>/<code>puts</code>/<code>getchar</code>/<code>putchar</code>&nbsp;등 C의 입출력 방식을 사용하면 안 된다.</p>
<p>Java를 사용하고 있다면,&nbsp;<code>Scanner</code>와&nbsp;<code>System.out.println</code>&nbsp;대신&nbsp;<code>BufferedReader</code>와&nbsp;<code>BufferedWriter</code>를 사용할 수 있다.&nbsp;<code>BufferedWriter.flush</code>는 맨 마지막에 한 번만 하면 된다.</p>
</div>
