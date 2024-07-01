
<div class="headline">
<h2>문제</h2>
</div>
<div id="problem_description" class="problem-text">
<p>N+1개의 <code>I</code>와 N개의 <code>O</code>로 이루어져 있으면, <code>I</code>와 <code>O</code>이 교대로 나오는 문자열을 P<sub>N</sub>이라고 한다.</p>
<ul>
<li>P<sub>1</sub> <code>IOI</code></li>
<li>P<sub>2</sub> <code>IOIOI</code></li>
<li>P<sub>3</sub> <code>IOIOIOI</code></li>
<li>P<sub>N</sub> <code>IOIOI...OI</code> (<code>O</code>가 N개)</li>
</ul>
<p><code>I</code>와 <code>O</code>로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 P<sub>N</sub>이 몇 군데 포함되어 있는지 구하는 프로그램을 작성하시오.</p>
</div>

<div class="headline">
<h2>입력</h2>
</div>
<div id="problem_input" class="problem-text">
<p>첫째 줄에 N이 주어진다. 둘째 줄에는 S의 길이 M이 주어지며, 셋째 줄에 S가 주어진다.</p>
</div>

<div class="headline">
<h2>출력</h2>
</div>
<div id="problem_output" class="problem-text">
<p>S에 P<sub>N</sub>이 몇 군데 포함되어 있는지 출력한다.</p>
</div>

<div class="headline">
<h2>제한</h2>
</div>
<div id="problem_limit" class="problem-text">
<ul>
<li>1 ≤ N ≤ 1,000,000</li>
<li>2N+1 ≤ M ≤ 1,000,000</li>
<li>S는 <code>I</code>와 <code>O</code>로만 이루어져 있다.</li>
</ul>
</div>
<div class="headline"><h2>서브태스크</h2></div><div id="problem_subtask" class="problem-text"><div class="table-responsive"><table class="table table-bordered td-middle subtask-table" style="width: 100%;"><thead><tr><th style="width: 5%;">번호</th><th style="width: 5%;">배점</th><th style="width: 90%;">제한</th></tr></thead><tbody><tr data-subtask-id="1"><td>1</td><td>50</td><td class="subtask-body"><p>N ≤ 100, M ≤ 10 000.</p>
</td></tr><tr data-subtask-id="2"><td>2</td><td>50</td><td class="subtask-body"><p>추가적인 제약 조건이 없다.</p>
</td></tr></tbody></table></div></div>
<div class="headline">
<h2>예제 입력 1
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-input-1">복사</button>
</h2>
</div>

```
1
13
OOIOIOIOIIOII
```

<div class="headline">
<h2>예제 출력 1
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-output-1">복사</button>
</h2>
</div>

```
4
```

<div id="problem_sample_explain_1" class="problem-text">
<ul>
<li><code>OO<u>IOI</u>OIOIIOII</code></li>
<li><code>OOIO<u>IOI</u>OIIOII</code></li>
<li><code>OOIOIO<u>IOI</u>IOII</code></li>
<li><code>OOIOIOIOI<u>IOI</u>I</code></li>
</ul>
</div>

<div class="headline">
<h2>예제 입력 2
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-input-2">복사</button>
</h2>
</div>

```
2
13
OOIOIOIOIIOII
```

<div class="headline">
<h2>예제 출력 2
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-output-2">복사</button>
</h2>
</div>

```
2
```

<div id="problem_sample_explain_2" class="problem-text">
<ul>
<li><code>OO<u>IOIOI</u>OIIOII</code></li>
<li><code>OOIO<u>IOIOI</u>IOII</code></li>
</ul>
</div>

<div class="headline">
<h2>힌트</h2>
</div>
<div id="problem_hint" class="problem-text">
</div>
