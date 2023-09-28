package com.emilabdurahmanli.brodcastreciever.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.emilabdurahmanli.brodcastreciever.R
import com.emilabdurahmanli.brodcastreciever.databinding.FragmentBlankBinding
import com.emilabdurahmanli.brodcastreciever.repository.DataRepository
import com.emilabdurahmanli.brodcastreciever.veiw_model.BlankViewModel
import com.squareup.picasso.Picasso


class BlankFragment : Fragment() {


    private lateinit var binding : FragmentBlankBinding
    private lateinit var viewModel : BlankViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentBlankBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[BlankViewModel::class.java]
        viewModel.getData()

        viewModel.observeMessage().observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        })
        DataRepository.data.observe(viewLifecycleOwner, Observer {
            binding.data = it
            Picasso.get().load(it.thumbnail).into(binding.imageView);
        })

    }


}