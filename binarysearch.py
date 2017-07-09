'''
Created on Jul 8, 2017


'''
#Write a method that implements binary search on a sorted array
#iterative solution
def binsrch(x,arr):
    start = 0
    end = len(arr)
    mid = 0
    while  start <= end:        
        mid = int((start+end)/2)       
        if(x == arr[mid]):
            return mid
        elif x > arr[mid]:
            start = mid + 1
        else:
            end = mid - 1
    return -1

print(binsrch(10, [1,3,4,5,7,8,10]))