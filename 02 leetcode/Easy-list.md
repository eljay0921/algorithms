---

# [605. Can Place Flowers](https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75)
## 꽃 심기 문제 (Flower Planting Problem)

길게 늘어진 **화단**이 있는데, 일부 구획에는 꽃이 심어져 있고 일부는 비어 있습니다. 단, **인접한** 구획에는 꽃을 심을 수 없습니다.

`0`은 비어 있음을, `1`은 비어 있지 않음을 나타내는 **정수 배열 `flowerbed`**와 **정수 `n`**이 주어졌을 때, **인접한 꽃 금지 규칙을 위반하지 않고** `n`개의 새로운 꽃을 화단에 심을 수 있다면 `true`를, 그렇지 않으면 `false`를 반환하세요.

### 예시

**예시 1:**
* 입력: `flowerbed = [1,0,0,0,1]`, `n = 1`
* 출력: `true`
    * (중간의 `0` 세 개 중 하나에 꽃을 심을 수 있습니다.)

**예시 2:**
* 입력: `flowerbed = [1,0,0,0,1]`, `n = 2`
* 출력: `false`
    * (중간에 심을 수 있는 공간은 한 곳 뿐이므로, 두 개의 꽃을 심을 수 없습니다.)

### 제약 조건

* `1 <= flowerbed.length <= 2 * 10^4`
* `flowerbed[i]`는 `0` 또는 `1`입니다.
* `flowerbed`에는 인접한 두 개의 꽃이 없습니다. (초기 상태는 규칙을 만족합니다.)
* `0 <= n <= flowerbed.length`

---

# [345. Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75)
## 문자열의 모음 뒤집기 (Reverse Vowels of a String)

**문자열 `s`**가 주어졌을 때, 해당 문자열의 모든 모음만 뒤집어 반환하세요.

모음은 **'a', 'e', 'i', 'o', 'u'**이며, 소문자와 대문자 모두 가능하고 여러 번 나타날 수 있습니다.

### 예시

**예시 1:**
* 입력: `s = "IceCreAm"`
* 출력: `"AceCreIm"`
    * 설명: `s`의 모음은 `['I', 'e', 'e', 'A']`입니다. 모음을 뒤집으면 `s`는 `"AceCreIm"`이 됩니다.

**예시 2:**
* 입력: `s = "leetcode"`
* 출력: `"leotcede"`

### 제약 조건

* `1 <= s.length <= 3 * 10^5`
* `s`는 **출력 가능한 ASCII 문자**로 구성됩니다.

---

# [151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/description/)
## 문자열의 단어 뒤집기 (Reverse Words in a String)

주어진 **입력 문자열 `s`**에서 **단어들의 순서**를 뒤집어 반환하세요.

**단어**는 공백이 아닌 문자들의 연속된 시퀀스로 정의됩니다. `s` 안의 단어들은 하나 이상의 공백으로 구분됩니다.

뒤집힌 단어들을 **하나의 공백으로 연결하여** 문자열로 반환하세요.

**참고**: `s`는 앞뒤 공백이나 두 단어 사이에 여러 개의 공백을 포함할 수 있습니다. 반환되는 문자열은 단어들을 하나의 공백으로만 구분해야 합니다. 추가적인 공백을 포함하지 마세요.

### 예시

**예시 1:**
* 입력: `s = "the sky is blue"`
* 출력: `"blue is sky the"`

**예시 2:**
* 입력: `s = "  hello world  "`
* 출력: `"world hello"`
    * 설명: 뒤집힌 문자열은 앞뒤 공백을 포함해서는 안 됩니다.

**예시 3:**
* 입력: `s = "a good   example"`
* 출력: `"example good a"`
    * 설명: 뒤집힌 문자열에서 두 단어 사이의 여러 공백은 하나의 공백으로 줄여야 합니다.

### 제약 조건

* `1 <= s.length <= 10^4`
* `s`는 영어 알파벳 (대소문자), 숫자, 그리고 공백 `' '`을 포함합니다.
* `s`에는 **최소한 하나의 단어**가 있습니다.

### 후속 질문 (Follow-up)

만약 사용하는 언어에서 문자열 데이터 타입이 변경 가능하다면, **O(1) 추가 공간**으로 제자리(in-place)에서 문제를 해결할 수 있습니까?

---

# [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description/)
## 자신을 제외한 배열의 곱 (Product of Array Except Self)

**정수 배열 `nums`**가 주어졌을 때, `answer[i]`가 `nums[i]`를 제외한 `nums`의 모든 요소의 곱과 같도록 하는 **배열 `answer`**를 반환하세요.

`nums`의 어떤 접두사(prefix) 또는 접미사(suffix)의 곱도 **32비트 정수** 범위 내에 들어옴이 **보장됩니다**.

이 알고리즘은 **O(n) 시간 복잡도**로 실행되어야 하며, **나눗셈 연산을 사용해서는 안 됩니다.**

### 예시

**예시 1:**
* 입력: `nums = [1,2,3,4]`
* 출력: `[24,12,8,6]`
    * 설명:
        * `answer[0] = 2 * 3 * 4 = 24`
        * `answer[1] = 1 * 3 * 4 = 12`
        * `answer[2] = 1 * 2 * 4 = 8`
        * `answer[3] = 1 * 2 * 3 = 6`

**예시 2:**
* 입력: `nums = [-1,1,0,-3,3]`
* 출력: `[0,0,9,0,0]`

### 제약 조건

* `2 <= nums.length <= 10^5`
* `-30 <= nums[i] <= 30`
* 입력은 `answer[i]`가 **32비트 정수 범위 내에 들어옴이 보장**되도록 생성됩니다.

### 후속 질문 (Follow-up)

**O(1) 추가 공간 복잡도**로 문제를 해결할 수 있습니까? (출력 배열은 공간 복잡도 분석 시 추가 공간으로 계산되지 않습니다.)