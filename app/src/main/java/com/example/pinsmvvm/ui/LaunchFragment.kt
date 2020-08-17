package com.example.pinsmvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pinsmvvm.R
import com.example.pinsmvvm.app.config.Setting
import com.example.pinsmvvm.app.utils.findNavController
import com.example.pinsmvvm.app.utils.navigateAction

class LaunchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_launch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (Setting.authorization.isNotEmpty()) {
            findNavController().navigateAction(R.id.action_launchFragment_to_mainFragment)
        } else {
            findNavController().navigateAction(R.id.action_launchFragment_to_loginFragment)
        }
    }
}