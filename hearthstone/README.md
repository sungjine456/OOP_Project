# 하스스톤(Hearth Stone Game)

### 게임의 규칙
> 두 명의 플레이어가 대전을 펼쳐 상대방의 체력을 0 이하로 만들면 이기는 게임
```
게임을 시작하면 공격의 선 후를 심판이 랜덤으로 결정한다.
선공을 하게된 플레이어는 3장의 카드를 얻고 후공을 하게된 플레이어는 4장의 카드와 한턴에 한해 마나를 +1시켜주는 카드를 얻는다.
게임을 시작하기 전에 두 플레이어는 얻은 카드를 한 번 바꿀 수 있다.
두 플레이어 모두 마나는 1에서 시작하며 자신의 턴이 돌아올 때마다 마나는 1씩 증가한다.
하수인을 내고 바로 공격할 수 없다.
```

### 필요 객체
```
카드, 영웅, 심판, 플레이어
```
### 객체별 필요 요소
----

#### 카드
```
공통 - 소모되는 마나
하수인 카드 - 공격력, 체력, 능력
마법 카드 - 능력
무기 카드 - 공격력, 방어력
```

#### 영웅
```
상태 - 스킬(소모되는 마나, 능력), 무기(공격력, 방어력), 체력
```

#### 심판
```
게임 시작 준비(플레이어에게 영웅과 카드를 준다.)
플레이어가 턴을 종료하면 다른 플레이어에게 턴을 준다.
플레이어가 마나의 총량을 넘어서서 카드를 사용할 수 없게 한다.
하수인은 내자마자 공격할 수 없다.
하수인은 한 턴에 한 번만 공격할 수 있다.
플레이어가 내는 하수인 카드가 능력을 가졌다면 능력을 사용한다.
플레이어의 턴이 끝나면 턴이 끝난 플레이어의 마나를 늘려준다.(마나는 10을 넘길 수 없다.)
플레이어의 턴이 시작되면 카드 한 장을 카드 덱에서 꺼내라고 한다.
```

#### 플레이어
```
상태 - 들고있는 카드, 카드 덱, 낸 카드, 영웅, 마나 
턴을 종료한다.
영웅의 능력을 사용한다.
영웅으로 공격한다.
카드덱에서 카드 한 장을 꺼내서 든다.
들고 있는 하수인 카드를 낸다.
낸 하수인 카드를 사용한다.
마법 카드를 사용한다.
무기 카드를 영웅에게 준다.
```