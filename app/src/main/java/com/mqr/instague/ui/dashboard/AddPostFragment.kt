package com.mqr.instague.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mqr.instague.R

class AddPostFragment : Fragment() {

    private lateinit var addPostViewModel: AddPostViewModel
    private lateinit var textView: TextView


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_add_post, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.text_add_post)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(activity != null){
            addPostViewModel = ViewModelProvider(this).get(AddPostViewModel::class.java)
            observViewModel()
        }
    }

    private fun observViewModel() {
        addPostViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
    }
}
