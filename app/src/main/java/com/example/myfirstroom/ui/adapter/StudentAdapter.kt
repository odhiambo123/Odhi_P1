package com.example.myfirstroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstroom.model.Student

class StudentAdapter(private val onCardClick: (position: Int) -> Unit,
                     private var studentList:List<Student>): RecyclerView.Adapter<ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflate a view and return it
        val view  =  LayoutInflater.from(parent.context).inflate(R.layout.student_list_layout
        ,parent,false)
        return ViewHolder(view, onCardClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //add current item to the holder
        val itemVM = studentList[position]

        holder.fname.text = itemVM.firstName
        holder.lname.text = itemVM.lastName
        //holder.stud_Id.text = itemVM.studentId.toString()

    }
    fun setItem(studentList: List<Student>){
        this.studentList = studentList
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
       //return the size of the datasource
        return studentList.size
    }
}
class ViewHolder(view: View, private val onCardClick: (position: Int) -> Unit)
    :RecyclerView.ViewHolder(view), View.OnClickListener  {
    init {
        itemView.setOnClickListener(this)

    }
    val fname : TextView = view.findViewById(R.id.fname)
    val lname : TextView = view.findViewById(R.id.lname)
    //6
    override fun onClick(v: View?) {
        val position = adapterPosition
        //7 - the function below is what is passed and referring to the one in MainActivity
        onCardClick(position)
    }
}
