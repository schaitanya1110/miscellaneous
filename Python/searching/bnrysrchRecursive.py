'''
Created on Jul 8, 2017


'''
#Write a method that implements binary search on a sorted array
#Recursive solution
def binsrch(x,sr,er,arr):
    start = sr
    end = er
    mid = 0
    
    mid = int((start+end)/2)
    if(x == arr[mid]):
        return mid
    elif x > arr[mid]:
        #start = mid + 1
        return binsrch(x,mid+1,end,arr)
    else:
        #end = mid - 1
        return binsrch(x,start,mid - 1 ,arr)
    return -1

print(binsrch(8,0,7, [1,3,4,5,7,8,10]))
