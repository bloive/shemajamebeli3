package com.example.shemajamebeli3

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shemajamebeli3.databinding.FragmentFirstBinding
import com.example.shemajamebeli3.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var viewModel: ItemViewModel

    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())
                .get(ItemViewModel::class.java)

        init()
        binding.btnSave.setOnClickListener{
            viewModel.save(UserModel(binding.editTextName.text.toString(),
            binding.editTextSurname.text.toString(),
            binding.editTextEmail.text.toString()))
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
            d("user ", "${viewModel.currentUser.value}")
            d("users ", "${viewModel.data.value}")
        }
    }

    private fun init() {
        binding.editTextName.setText(viewModel.currentUser.value?.name)
        binding.editTextSurname.setText(viewModel.currentUser.value?.surname)
        binding.editTextEmail.setText(viewModel.currentUser.value?.email)
    }
}