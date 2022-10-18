package db

import db.dbIn.*
import interchanges.Answerable

class DB {

   fun getInterchanges() : MutableList<Answerable>{
       val interchanges = mutableListOf<Answerable>()

       interchanges.apply {
           addAll(DBicA.getInterchanges())
           addAll(DBicB.getInterchanges())
           addAll(DBicC.getInterchanges())
           addAll(DBicE.getInterchanges())
       }

       return interchanges
   }
}