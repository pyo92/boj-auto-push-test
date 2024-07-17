<img src = 'https://d2gd6pc034wcta.cloudfront.net/tier/5.svg' style="width: 20px"> &nbsp; $\Huge{\textsf{\color{#ad5600}Bronze Ⅰ}}$
<br>
<h1>[<a href='https://www.acmicpc.net/problem/11050'>11050번</a>] 이항 계수 1</h1>
<br>
<br>

<div class="headline">
<h2>문제</h2>
</div>
<div id="problem_description" class="problem-text">
<p>자연수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">\(N\)</span></mjx-container>과 정수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D43E TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>K</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">\(K\)</span></mjx-container>가 주어졌을 때 이항 계수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mrow><mjx-texatom texclass="OPEN"><mjx-mo class="mjx-sop"><mjx-c class="mjx-c28 TEX-S1"></mjx-c></mjx-mo></mjx-texatom><mjx-mfrac><mjx-frac atop="true" delims="true" style="vertical-align: -0.345em;"><mjx-num style="padding-bottom: 0.306em;"><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-num><mjx-den><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D43E TEX-I"></mjx-c></mjx-mi></mjx-den></mjx-frac></mjx-mfrac><mjx-texatom texclass="CLOSE"><mjx-mo class="mjx-sop"><mjx-c class="mjx-c29 TEX-S1"></mjx-c></mjx-mo></mjx-texatom></mjx-mrow></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mrow data-mjx-texclass="ORD"><mrow data-mjx-texclass="OPEN"><mo minsize="1.2em" maxsize="1.2em">(</mo></mrow><mfrac linethickness="0"><mi>N</mi><mi>K</mi></mfrac><mrow data-mjx-texclass="CLOSE"><mo minsize="1.2em" maxsize="1.2em">)</mo></mrow></mrow></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">\(\binom{N}{K}\)</span></mjx-container>를&nbsp;구하는 프로그램을 작성하시오.</p>
</div>

<div class="headline">
<h2>입력</h2>
</div>
<div id="problem_input" class="problem-text">
<p>첫째 줄에 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">\(N\)</span></mjx-container>과 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D43E TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>K</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">\(K\)</span></mjx-container>가 주어진다. (1 ≤ <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">\(N\)</span></mjx-container> ≤ 10, 0 ≤ <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D43E TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>K</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">\(K\)</span></mjx-container> ≤ <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">\(N\)</span></mjx-container>)</p>
</div>

<div class="headline">
<h2>출력</h2>
</div>
<div id="problem_output" class="problem-text">
<p>&nbsp;<mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mrow><mjx-texatom texclass="OPEN"><mjx-mo class="mjx-sop"><mjx-c class="mjx-c28 TEX-S1"></mjx-c></mjx-mo></mjx-texatom><mjx-mfrac><mjx-frac atop="true" delims="true" style="vertical-align: -0.345em;"><mjx-num style="padding-bottom: 0.306em;"><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-num><mjx-den><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D43E TEX-I"></mjx-c></mjx-mi></mjx-den></mjx-frac></mjx-mfrac><mjx-texatom texclass="CLOSE"><mjx-mo class="mjx-sop"><mjx-c class="mjx-c29 TEX-S1"></mjx-c></mjx-mo></mjx-texatom></mjx-mrow></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mrow data-mjx-texclass="ORD"><mrow data-mjx-texclass="OPEN"><mo minsize="1.2em" maxsize="1.2em">(</mo></mrow><mfrac linethickness="0"><mi>N</mi><mi>K</mi></mfrac><mrow data-mjx-texclass="CLOSE"><mo minsize="1.2em" maxsize="1.2em">)</mo></mrow></mrow></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">\(\binom{N}{K}\)</span></mjx-container>를&nbsp;출력한다.</p>
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
5 2

```

<div class="headline">
<h2>예제 출력 1
<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-output-1">복사</button>
</h2>
</div>

```
10

```

<div class="headline">
<h2>힌트</h2>
</div>
<div id="problem_hint" class="problem-text">
</div>
