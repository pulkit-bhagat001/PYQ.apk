package com.exam.paper.data.Repository

import com.exam.paper.data.States.PdfItem
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

class Repository @Inject constructor(val firebaseDatabase: FirebaseDatabase) {

    fun getSemestersList(root:String,sendSemListToCallback:(List<String>)->Unit){
        firebaseDatabase.reference.child(root).addListenerForSingleValueEvent(
            object:ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val semList=snapshot.children.map { it.key.orEmpty() }
                    sendSemListToCallback(semList)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            }
        )
    }
    fun getSubjectsList(root:String,semester:String,sendSubListToCallback:(List<String>)->Unit){
        firebaseDatabase.reference.child(root).child(semester).addValueEventListener(
            object:ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val subList=snapshot.children.map { it.key.orEmpty() }
                    sendSubListToCallback(subList)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            }
        )
    }
    fun getPapersList(root:String,semester:String,subject:String,sendPaperListToCallback:(List<PdfItem>)->Unit){
        firebaseDatabase.reference.child(root).child(semester).child(subject).addValueEventListener(
            object:ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list= mutableListOf<PdfItem>()
                    for(child in snapshot.children){
                        val name=child.key.orEmpty()
                        val value=child.getValue(String::class.java).orEmpty()
                        list.add(PdfItem(name,value))
                    }
                    sendPaperListToCallback(list)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            }
        )
    }


}