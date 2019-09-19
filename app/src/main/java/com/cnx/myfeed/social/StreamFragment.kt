package com.cnx.myfeed.social


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.cnx.myfeed.FeedAdapter
import com.cnx.myfeed.databinding.FragmentStreamBinding
import com.cnx.myfeed.utilities.InjectorUtils
import com.cnx.myfeed.viewModels.MyFeedViewModel


class StreamFragment : Fragment() {


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

        val binding  = FragmentStreamBinding.inflate(inflater,container,false)
        context ?: return binding.root
        val adapter = FeedAdapter()
        binding.rvFeed.adapter = adapter
        subscribeUI(adapter)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.d("onActivityCreated","called")


    }

    private fun subscribeUI(adapter: FeedAdapter) {

        viewModel.feeds.observe(this, Observer { feeds ->

            Log.d("mainactivity","${feeds.loadedCount}")

            adapter.submitList(feeds)
        })

        adapter.notifyDataSetChanged()


    }

    override fun onResume() {
        super.onResume()


    }


}
