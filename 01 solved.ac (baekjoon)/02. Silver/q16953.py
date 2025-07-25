"""백준 16953"""

def get_count(num_a, num_b) :
    """get count"""

    count = 1
    while num_b > num_a :

        if num_b % 2 == 0 :
            num_b = num_b // 2
        elif num_b % 10 == 1 :
            num_b = num_b // 10
        else :
            return -1
        count = count + 1

    if num_b == num_a :
        return count
    return -1

if __name__ == "__main__" :
    origin, target = map(int, input().split())
    print(get_count(origin, target))
