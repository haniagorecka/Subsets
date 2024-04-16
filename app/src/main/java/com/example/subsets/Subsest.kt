package com.example.subsets

/**
 * @author Hanna Górecka
 * Funkcja rekurencyjnie dodaje listę wszystkich liczb binarnych o długości n do listy list
 * @param n długość liczb binarnych
 * @param list lista list, do której dodane zostaną liczby binarne
 * @param i iterator
 * @param arr zmienna tymczasowa, lista, która jest zmieniana w celu przejścia przez wszytskie liczby binarne
 * @throws Exception jeśli podana długość liczby binarnej jest ujemna
 * @throws Exception jeśli iterator jest ujemny
 *
 * Wspomogłam się algorytmem wypisywania liczb binarnych z: https://www.geeksforgeeks.org/generate-all-the-binary-strings-of-n-bits/
 */
fun allBinary(n: Int, list: MutableList<List<Int>>, i: Int, arr: MutableList<Int>)
{
    if(n<0) throw Exception ("Długość liczby nie może być mniejsza niż 0")
    if(i<0) throw Exception ("Iterator nie może być na ujemnej pozycji")
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

/**
 * @author Hanna Górecka
 * Funkcja zwraca listę list, będących wszystkimi podzbiorami podanego zbioru
 * @param list lista, będąca zbiorem, z którego trzeba wyznaczyć podzbiory
 * @return lista podzbiorów
 *
 * Zainspirowałam się algorytmem przedstawionym w pytaniu użytkownika azonips w https://4programmers.net/Forum/Inne/167256-Algorytm_znajdywania_wszystkich_podzbiorow_danego_zbioru?fbclid=IwAR1JgneaWoUcm7d73cYB74IGo2ke7I8N9isF-a5oXuUrszfFn5EK7fMR0fg_aem_AUzeYB96MaJxZ59VmaEMmJ-7xH_xm2xv3RfpvBACM9gvC2pAagk3ndjI9XUTdkQC8aLVyF8Y3D_HTy3HbES7_wck
 */
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

/**
 * Funkcja testująca funkcję subsets()
 */
fun testSubset()
{
    val set = mutableListOf(1,2)
    val subsets = mutableListOf<List<Int>>()
    subsets+= listOf<Int>()
    subsets+= listOf<Int>(2)
    subsets+= listOf<Int>(1)
    subsets+= listOf<Int>(1,2)

    assert(subsets==subsets(set), {"Test funkcji zwracającej podzbiory zakończony niepowodzeniem"})
    println("Test funkcji zwracającej podzbiory zakończony powodzeniem")
}
/**
 * Funkcja testująca funkcję allBinary()
 */
fun testBinary()
{
    val binary = mutableListOf<List<Int>>()
    binary += listOf<Int>(0,0)
    binary += listOf<Int>(0,1)
    binary +=listOf<Int>(1,0)
    binary += listOf<Int>(1,1)
    val binary2 = mutableListOf<List<Int>>()
    val arr = mutableListOf<Int>(0,0)
    allBinary(2, binary2, 0, arr)
    assert(binary==binary2, {"Test funkcji zwracającej wszystkie liczby binarne o długości n zakończony niepowodzeniem"})
    println("Test funkcji zwracającej wszystkie liczby binarne o długości n zakończony powodzeniem")
}

fun main ()
{
testBinary()
testSubset()
}