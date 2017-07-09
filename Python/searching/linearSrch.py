#Write a function that performs linear search in an array.
def LinearSrch(x,arr):
    for i in range(len(arr)):
        if x == arr[i]:
            return i
    return -1

print(LinearSrch(2, [1,4,6,7,8,4,8,2,6,3,7,8,3]))