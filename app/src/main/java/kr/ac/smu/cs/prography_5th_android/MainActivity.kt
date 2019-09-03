package kr.ac.smu.cs.prography_5th_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_fragment_two.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter=MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentOne(),"Call")
        adapter.addFragment(FragmentTwo(),"Chats")
        adapter.addFragment(FragmentThree(),"Contacts")
        viewPager.adapter=adapter
        tabs.setupWithViewPager(viewPager)
        tabs.getTabAt(0)?.setIcon(R.drawable.call)
        tabs.getTabAt(1)?.setIcon(R.drawable.chats)
        tabs.getTabAt(2)?.setIcon(R.drawable.contacts)
        /*recyclerView = findViewById(R.id.recyclerView)
        recyclerAdapter = RecyclerAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter


        val apiInterface = ApiInterface.create().getMovies()

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>?, response: Response<List<Movie>>?) {

                if(response?.body() != null)
                    recyclerAdapter.setMovieListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<Movie>>?, t: Throwable?) {
                Text2.text="{$t}"

            }
        })*/
    }

    class MyViewPagerAdapter(manager:FragmentManager):FragmentPagerAdapter(manager) {
        private val fragmentList:MutableList<Fragment> = ArrayList()
        private val titleList:MutableList<String> = ArrayList()
        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }
        fun addFragment(fragment:Fragment,title:String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }
}
