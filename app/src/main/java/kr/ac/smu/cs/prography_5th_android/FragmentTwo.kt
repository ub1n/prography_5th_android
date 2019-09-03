package kr.ac.smu.cs.prography_5th_android


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_fragment_two.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Response.success


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentTwo : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter
   var movieList:List<Movie> = listOf()
   fun setMovieListItem(movieList: List<Movie>){
       this.movieList = movieList;

   }


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this  fragment

        return inflater.inflate(R.layout.fragment_fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        Text2.text="CHATS"
        //Text2.text=movieList.get(2).description

        //recyclerView = findViewById(R.id.recyclerView)
        recyclerView= getView()!!.findViewById(R.id.recyclerView)
        recyclerAdapter = RecyclerAdapter(activity)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        recyclerView.adapter = recyclerAdapter



        val apiInterface = ApiInterface.create().getMovies()

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>?, response: Response<List<Movie>>?) {

                if(response?.body() != null) {
                    recyclerAdapter.setMovieListItems(response.body()!!)

                }


            }

            override fun onFailure(call: Call<List<Movie>>?, t: Throwable?) {
                Text2.text="{$t}"

            }
        })

        /*recyclerAdapter.itemClick=object: RecyclerAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                var intent= Intent(activity,information::class.java)
                //intent.putExtra("title",movieList[position].title)
                // intent.putExtra("des",movieList.get(position).description)
                //intent.putExtra("prod",movieList[position].producer)
                //intent.putExtra("reD",movieList[position].releaseDate)
                // intent.putExtra("rtS",movieList[position].rtScore)
                startActivityForResult(intent,1)
            }

        }*/

        recyclerView.addItemDecoration(
            DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))

    }

    
}
