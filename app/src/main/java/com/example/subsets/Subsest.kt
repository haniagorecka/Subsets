package com.example.subsets

fun allBinary(n: Int, list: MutableList<List<Int>>, i: Int, arr: MutableList<Int>) //https://www.geeksforgeeks.org/generate-all-the-binary-strings-of-n-bits/
{
    if (i == n) {
        var temp = arr.toList()
        list.add(list.size,temp)
    return
    }




    arr[i] = 0
    allBinary(n, list, i + 1, arr)
    arr[i] = 1
    allBinary(n, list, i + 1, arr)

}

fun subsets (list: MutableList<Int>):List<List<Int>>
{
    val n = list.size
    var subsets = mutableListOf<List<Int>>()
    var binary = mutableListOf<List<Int>>()
    if(n==0)
    {
        return subsets
    }
    var i: Int=0
    var arr = mutableListOf<Int>()
    for(k: Int in 0..<n)
    {
        arr+=0
    }
   allBinary(n,binary,0,arr)

   for(k: Int in 0..<binary.size)
   { var temp = mutableListOf<Int>()
       for(j: Int in 0..<binary[k].size)
       {
           if(binary[k][j]==1)
           {
               temp+=list[j]
           }

       }

       temp.toList()
       subsets.add(temp)
   }
    return subsets
}


fun main ()
{
var newarr = mutableListOf<Int>(1,2,3,4)

    println("${subsets(newarr)}")

}