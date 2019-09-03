package kr.ac.smu.cs.prography_5th_android

import android.content.Intent
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.coroutines.experimental.coroutineContext

class RecyclerAdapter(val context: FragmentActivity?) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var movieList : List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_adapter,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvMovieName.text = movieList.get(position).title
        /*Glide.with(context).load(movieList.get(position).image)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)*/
        holder.textView2.text=movieList.get(position).director
        holder.textRelease.text=movieList.get(position).releaseDate
        val num=position+1
        holder.textNumber.text= "$num"
        /*if(itemClick != null)
        {
            holder?.itemView?.setOnClickListener { v ->
                itemClick?.onClick(v, position)
            }
        }*/
        holder.itemView.setOnClickListener{ view->
            var intent = Intent(view.getContext(), information::class.java)
            intent.putExtra("title",movieList[position].title)
            intent.putExtra("des", movieList.get(position).description)
            intent.putExtra("prod",movieList[position].producer)
            intent.putExtra("reD",movieList[position].releaseDate)
            intent.putExtra("rtS",movieList[position].rtScore)
            view.getContext().startActivity(intent)
        }




    }

    fun setMovieListItems(movieList: List<Movie>){
        this.movieList = movieList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val tvMovieName: TextView = itemView!!.findViewById(R.id.textTitle)
        //val image: ImageView = itemView!!.findViewById(R.id.image)
        val textView2: TextView =itemView!!.findViewById(R.id.textDirector)
        val textRelease: TextView=itemView!!.findViewById(R.id.textRel)
        val textNumber:TextView=itemView!!.findViewById(R.id.textNum)


    }
    //interface ItemClick
    //{
        fun onClick(view: View, position: Int) {
            var intent = Intent(view.getContext(), information::class.java)
            //intent.putExtra("title",movieList[position].title)
            intent.putExtra("des", movieList.get(position).description)
            //intent.putExtra("prod",movieList[position].producer)
            //intent.putExtra("reD",movieList[position].releaseDate)
            // intent.putExtra("rtS",movieList[position].rtScore)
            view.getContext().startActivity(intent)
        //}
    }
    //var itemClick: ItemClick? = null



}