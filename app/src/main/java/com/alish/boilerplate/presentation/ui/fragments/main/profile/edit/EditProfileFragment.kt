package com.alish.boilerplate.presentation.ui.fragments.main.profile.edit

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.R
import com.alish.boilerplate.databinding.FragmentEditProfileBinding
import com.alish.boilerplate.presentation.base.BaseFragment
import com.alish.boilerplate.presentation.ui.fragments.main.profile.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditProfileFragment : BaseFragment<ProfileViewModel, FragmentEditProfileBinding>(
    R.layout.fragment_edit_profile
) {

    override val viewModel: ProfileViewModel by viewModels()
    override val binding by viewBinding(FragmentEditProfileBinding::bind)
}