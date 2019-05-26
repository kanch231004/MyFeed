package com.cnx.myfeed.social


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cnx.myfeed.FeedAdapter
import com.cnx.myfeed.R
import com.cnx.myfeed.utilities.InjectorUtils
import com.cnx.myfeed.viewModels.MyFeedViewModel
import kotlinx.android.synthetic.main.fragment_stream.*


class StreamFragment : Fragment() {

    val feedAdapter = FeedAdapter()

    private val viewModel: MyFeedViewModel by viewModels {
        InjectorUtils.provideFeedViewModelFactory(context!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("onCreateVeiw Stream","called")

        val view =inflater.inflate(R.layout.fragment_stream, container, false)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("onViewCreated","called")
        rvFeed.layoutManager = LinearLayoutManager(context!!)
        rvFeed.adapter = feedAdapter



    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.d("onActivityCreated","called")


    }

    override fun onResume() {
        super.onResume()

        viewModel.feeds.observe(this, Observer { feeds ->

            Log.d("mainactivity","${feeds.loadedCount}")

            feedAdapter.submitList(feeds)
        })

        feedAdapter.notifyDataSetChanged()
    }


}
