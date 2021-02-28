// Copyright (C) 2011-2012 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.knoldus
import scala.annotation.tailrec

class Sorting{

    def sort(input:List[Int]):List[Int]={

        def getLargest(inputList: List[Int]): (Int, List[Int]) = inputList match {

            // Case for last element
            case head :: List()  => (head, List())

            // Case for list
            case head :: tail =>{
                val (largeNum, remainingList) = getLargest(tail)
                if (largeNum > head){
                    (largeNum, head :: remainingList)
                }
                else{
                    (head, largeNum :: remainingList)
                }
            }

        }
        @tailrec
        def bubbleSort(inputList: List[Int],remaining:List[Int]): List[Int] = inputList match {
            case Nil => remaining
            case _   =>{
                val (largest, tail) = getLargest(inputList)
                bubbleSort(tail,List(largest):::remaining)
            }

        }

        input match{
            // Throw exception if list is empty
            case Nil => throw new NoSuchElementException("List is empty")
            // Calll bubbleSort function if list is not empty
            case _ =>bubbleSort(input,Nil)
        }

    }

}
