<img src = 'https://d2gd6pc034wcta.cloudfront.net/tier/13.svg' style="width: 20px"> &nbsp; $\Huge{\textsf{\color{#ec9a00}Gold Ⅲ}}$
<br>
<h1>[<a href='https://www.acmicpc.net/problem/1238'>1238번</a>] 파티</h1>
<br>
<br>

<div class="headline">
<h2>문제</h2>
</div>
<div id="problem_description" class="problem-text">
<p>N개의 숫자로 구분된 각각의 마을에 한 명의 학생이 살고 있다.</p>
<p>어느 날 이 N명의 학생이 X (1 ≤&nbsp;X ≤ N)번 마을에 모여서 파티를 벌이기로 했다. 이 마을 사이에는 총 M개의 단방향 도로들이 있고 i번째 길을 지나는데 T<sub>i</sub>(1 ≤ T<sub>i</sub> ≤ 100)의 시간을 소비한다.</p>
<p>각각의 학생들은 파티에 참석하기 위해 걸어가서 다시 그들의 마을로 돌아와야 한다. 하지만 이 학생들은 워낙 게을러서 최단 시간에 오고 가기를 원한다.</p>
<p>이 도로들은 단방향이기 때문에 아마 그들이 오고 가는 길이 다를지도 모른다. N명의 학생들 중 오고 가는데 가장 많은 시간을 소비하는 학생은 누구일지 구하여라.</p>
</div>

<div class="headline">
<h2>입력</h2>
</div>
<div id="problem_input" class="problem-text">
<p>첫째 줄에 N(1 ≤&nbsp;N ≤ 1,000), M(1 ≤ M ≤ 10,000), X가 공백으로 구분되어 입력된다. 두 번째 줄부터 M+1번째 줄까지 i번째 도로의 시작점, 끝점, 그리고 이 도로를 지나는데 필요한 소요시간 T<sub>i</sub>가 들어온다. 시작점과 끝점이 같은 도로는 없으며, 시작점과 한 도시 A에서 다른 도시 B로 가는 도로의 개수는 최대 1개이다.</p>
<p>모든 학생들은 집에서 X에 갈수 있고, X에서 집으로 돌아올 수 있는 데이터만 입력으로 주어진다.</p>
</div>

<div class="headline">
<h2>출력</h2>
</div>
<div id="problem_output" class="problem-text">
<p>첫 번째 줄에 N명의 학생들 중 오고 가는데 가장 오래 걸리는 학생의 소요시간을 출력한다.</p>
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
4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3

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
