package com.mnashat_dev.zkatelebel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mnashat_dev.zkatelebel.databinding.FragmentChoosenBinding


class ChoosenFragment : Fragment() {
    private lateinit var binding: FragmentChoosenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_choosen, container, false)
        binding.imageCamels.setOnClickListener {
            findNavController().navigate(R.id.action_choosenFragment_to_camleFragment)
        }
        binding.imageCows.setOnClickListener {
            findNavController().navigate(R.id.action_choosenFragment_to_cowsFragment)
        }
        binding.imageGoats.setOnClickListener {
            findNavController().navigate(R.id.action_choosenFragment_to_goatsFragment)
        }
        return binding.root;

    }

}