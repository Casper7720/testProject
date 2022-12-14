package com.example.testforeffectivemobile.presentation.screens.fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testforeffectivemobile.R
import com.example.testforeffectivemobile.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(layoutInflater)

        return binding.root
    }
}