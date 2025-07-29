"""백준 15681. 트리와 쿼리"""

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def dfs_for_dp(tree, dp, currentNode, visited) :
    """dfs for creating dp"""
    visited[currentNode] = True

    count = 1
    for nextNode in tree[currentNode] :
        
        if visited[nextNode] == False :
            visited[nextNode] = True
            count += dfs_for_dp(tree, dp, nextNode, visited)

    dp[currentNode] = count
    return count

def main() :
    """main()"""
    node_count, node_root, query_count = map(int, (input().split()))

    tree = [[] for _ in range(node_count + 1)]    # 아래와 같은 코드
    # tree = []
    # for _ in range(node_count + 1) :
    #     tree.append([])

    for _ in range(node_count - 1) :
        node1, node2 = map(int, input().split())
        tree[node1].append(node2)
        tree[node2].append(node1)

    dp = [0] * (node_count + 1)
    visited = [False] * (node_count + 1)
    dfs_for_dp(tree, dp, node_root, visited)

    result = []
    for _ in range(query_count) :

        query_node = int(input())
        result.append(str(dp[query_node]))

    sys.stdout.write("\n".join(result))

if __name__ == "__main__" :
    main()
