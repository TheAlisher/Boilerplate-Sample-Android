package com.alish.boilerplate.presentation.ui.fragments.sign.up

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.R
import com.alish.boilerplate.databinding.FragmentSignUpBinding
import com.alish.boilerplate.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseFragment<SignUpViewModel, FragmentSignUpBinding>(
    R.layout.fragment_sign_up
) {

    override val viewModel: SignUpViewModel by viewModels()
    override val binding by viewBinding(FragmentSignUpBinding::bind)
}