
<div class="headline">
<h2>문제</h2>
</div>
<div id="problem_description" class="problem-text">
<p>시작 -&gt; 실행 -&gt; cmd를 쳐보자. 검정 화면이 눈에 보인다. 여기서 dir이라고 치면 그 디렉토리에 있는 서브디렉토리와 파일이 모두 나온다. 이때 원하는 파일을 찾으려면 다음과 같이 하면 된다.</p>
<p>dir *.exe라고 치면 확장자가 exe인 파일이 다 나온다. "dir 패턴"과 같이 치면 그 패턴에 맞는 파일만 검색 결과로 나온다. 예를 들어, dir a?b.exe라고 검색하면 파일명의 첫 번째 글자가 a이고, 세 번째 글자가 b이고, 확장자가 exe인 것이 모두 나온다. 이때 두 번째 문자는 아무거나 나와도 된다. 예를 들어, acb.exe, aab.exe, apb.exe가 나온다.</p>
<p>이 문제는 검색 결과가 먼저 주어졌을 때, 패턴으로 뭘 쳐야 그 결과가 나오는지를 출력하는 문제이다. 패턴에는 알파벳과 "." 그리고 "?"만 넣을 수 있다. 가능하면 ?을 적게 써야 한다. 그 디렉토리에는 검색 결과에 나온 파일만 있다고 가정하고, 파일 이름의 길이는 모두 같다.</p>
</div>

<div class="headline">
<h2>입력</h2>
</div>
<div id="problem_input" class="problem-text">
<p>첫째 줄에 파일 이름의 개수 N이 주어진다. 둘째 줄부터 N개의 줄에는 파일 이름이 주어진다. N은 50보다 작거나 같은 자연수이고 파일 이름의 길이는 모두 같고 길이는 최대 50이다. 파일이름은 알파벳 소문자와 '.' 로만 이루어져 있다.</p>
</div>

<div class="headline">
<h2>출력</h2>
</div>
<div id="problem_output" class="problem-text">
<p>첫째 줄에 패턴을 출력하면 된다.</p>
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
3
config.sys
config.inf
configures
```

<div class="headline">
<h2>예제 출력 1
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-output-1">복사</button>
</h2>
</div>

```
config????
```

<div class="headline">
<h2>예제 입력 2
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-input-2">복사</button>
</h2>
</div>

```
2
contest.txt
context.txt
```

<div class="headline">
<h2>예제 출력 2
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-output-2">복사</button>
</h2>
</div>

```
conte?t.txt
```

<div class="headline">
<h2>예제 입력 3
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-input-3">복사</button>
</h2>
</div>

```
3
c.user.mike.programs
c.user.nike.programs
c.user.rice.programs
```

<div class="headline">
<h2>예제 출력 3
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-output-3">복사</button>
</h2>
</div>

```
c.user.?i?e.programs
```

<div class="headline">
<h2>예제 입력 4
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-input-4">복사</button>
</h2>
</div>

```
4
a
a
b
b
```

<div class="headline">
<h2>예제 출력 4
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-output-4">복사</button>
</h2>
</div>

```
?
```

<div class="headline">
<h2>예제 입력 5
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-input-5">복사</button>
</h2>
</div>

```
1
onlyonefile
```

<div class="headline">
<h2>예제 출력 5
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-output-5">복사</button>
</h2>
</div>

```
onlyonefile
```

<div class="headline">
<h2>힌트</h2>
</div>
<div id="problem_hint" class="problem-text">
</div>
