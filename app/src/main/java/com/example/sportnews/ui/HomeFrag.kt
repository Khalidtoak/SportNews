package com.example.sportnews.ui


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportnews.R
import com.example.sportnews.adapter.NewsAdapter
import com.example.sportnews.datamodel.SportNews
import com.example.sportnews.retrofit.RetroClient
import com.example.sportnews.retrofit.RetroInterface
import kotlinx.android.synthetic.main.fragment_home_frag.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFrag : Fragment() {
    private lateinit var getNews: Call<SportNews>
    private lateinit var newsRecyclerView :RecyclerView
    //private lateinit v
    private var TAG = "HomeFrag"
    var cont: Context? = context
    //private  var allNews

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
          //var newsfetch:List<SportNews>
        val rootView = inflater.inflate(R.layout.fragment_home_frag, container, false)

        val refreshBtn = rootView.findViewById<View>(R.id.refresh_button)
        val contentBtn = rootView.findViewById<View>(R.id.content_loading)
         newsRecyclerView = rootView.findViewById(R.id.home_recycler)
        newsRecyclerView.layoutManager = LinearLayoutManager(cont)

        refreshBtn.setOnClickListener {
            refreshBtn.visibility = View.INVISIBLE
            contentBtn.visibility = View.VISIBLE
            fetchSportNews(getNews)
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //use the api client to get the api interface
        val apiInterface = RetroClient.getRetrofit().create(RetroInterface::class.java)
        //call the getnews function
        getNews = apiInterface.getLatestNews(
            "76e05fa7414946f0a4a5e283bd2229b6",
            "gb", "sport"
        )
        //handle response and failure of the call
        fetchSportNews(getNews)

    }
    private fun fetchSportNews(getN: Call<SportNews>) {
        getN.clone().enqueue(object : Callback<SportNews> {
            override fun onFailure(call: Call<SportNews>, t: Throwable) {
                Toast.makeText(
                    cont, "Unable to connect "
                            + t.message, Toast.LENGTH_SHORT
                ).show()
                content_loading.visibility = View.INVISIBLE
                //show refresh button
                refresh_button.visibility = View.VISIBLE
            }

            override fun onResponse(call: Call<SportNews>, response: Response<SportNews>) {
              //  home_recycler.adapter = NewsAdapter(context!!, response.body()!!)
                //var sportAll = response.body()!! as List<SportNews>
                 newsRecyclerView.adapter = NewsAdapter(context!!, response.body()!!)

                content_loading.visibility = View.INVISIBLE
               // for (a in 1..sportAll.size){
               // Log.i(TAG,sportAll[a].toString())}
            }

        })
    }


}
