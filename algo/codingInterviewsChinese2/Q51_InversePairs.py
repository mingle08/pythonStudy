from typing import List


class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        def mergeSort(L, R):
            if L >= R:
                return 0
            m = L + (R - L) // 2
            cnt = mergeSort(L, m) + mergeSort(m + 1, R)
            i, j = L, m + 1
            pos = L
            while i <= m and j <= R:
                if nums[i] <= nums[j]:
                    tmp[pos] = nums[i]
                    i += 1
                else:
                    tmp[pos] = nums[j]
                    j += 1
                    cnt += (m - i + 1)
                pos += 1
            for k in range(i, m + 1):
                tmp[pos] = nums[k]
                pos += 1
            for k in range(j, R + 1):
                tmp[pos] = nums[k]
                pos += 1
            nums[L:R + 1] = tmp[L:R + 1]
            return cnt

        n = len(nums)
        tmp = [0] * n
        return mergeSort(0, n - 1)


if __name__ == '__main__':
    s = Solution();
    numbers = [9, 9, 0, 5, 2, 5, 8, 3]
    print(s.reversePairs(numbers))
