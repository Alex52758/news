package com.example.exam15.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam15.News
import com.example.exam15.NewsAdapter
import com.example.exam15.R
import com.example.exam15.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : Fragment() {



    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val newsList: List<News> = listOf(News("Custom news 1",resources.getString(R.string.lorem), Date()),
            News("Custom news 2", resources.getString(R.string.lorem), Date()),
            News("Custom news 3", resources.getString(R.string.lorem), Date()),News("Custom news 4", resources.getString(R.string.lorem), Date()),
            News("Custom news 5", resources.getString(R.string.lorem), Date()),News("Custom news 5", resources.getString(R.string.lorem), Date()),News("Custom news 5", resources.getString(R.string.lorem), Date()),News("Custom news 5", resources.getString(R.string.lorem), Date()),News("Custom news 5", resources.getString(R.string.lorem), Date()),News("Custom news 5", resources.getString(R.string.lorem), Date()))
        val rvNewsList = view.findViewById<RecyclerView>(R.id.rv_news)
        rvNewsList.adapter = NewsAdapter(newsList)
        rvNewsList.layoutManager = LinearLayoutManager(view.context)
        rvNewsList.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}