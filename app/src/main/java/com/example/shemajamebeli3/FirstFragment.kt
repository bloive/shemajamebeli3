package com.example.shemajamebeli3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli3.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var viewModel: ItemViewModel

    private lateinit var binding : FragmentFirstBinding
    private var users = mutableListOf<UserModel>()
    private lateinit var adapter : UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())
                .get(ItemViewModel::class.java)
        init()
    }

    private fun init() {
        adapter = UserAdapter(users, object : ItemListener {
            override fun delete(position: Int) {
                users.removeAt(position)
                adapter.notifyDataSetChanged()
            }

            override fun edit(position: Int) {
                startSecondFragment(users[position])
            }
        })
        setData()
        binding.recycler.layoutManager = LinearLayoutManager(activity)
        binding.recycler.adapter = adapter
    }

    private fun setData() {
//        if (viewModel.data.value != null) {
//            users = viewModel.data.value!!
//        } else {
//            users.add(UserModel("name", "surname", "email"))
//        }
        users.add(UserModel("name", "surname", "email"))
        users.add(UserModel("name", "surname", "email"))
        users.add(UserModel("name", "surname", "email"))
        adapter.notifyDataSetChanged()
    }

    private fun startSecondFragment(userModel: UserModel) {
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        viewModel.currentUser.value = userModel
    }
}